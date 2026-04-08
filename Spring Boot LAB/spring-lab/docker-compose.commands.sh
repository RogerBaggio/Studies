#!/bin/bash

# Cores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${GREEN}🐘 SpringLab - PostgreSQL Management${NC}"

case "$1" in
    start)
        echo -e "${YELLOW}Starting Docker containers...${NC}"
        docker-compose up -d
        echo -e "${GREEN}✅ Containers started!${NC}"
        echo -e "PostgreSQL: ${GREEN}localhost:5432${NC}"
        echo -e "pgAdmin: ${GREEN}http://localhost:5050${NC}"
        echo -e "Redis: ${GREEN}localhost:6379${NC}"
        ;;
    
    stop)
        echo -e "${YELLOW}Stopping Docker containers...${NC}"
        docker-compose down
        echo -e "${GREEN}✅ Containers stopped!${NC}"
        ;;
    
    logs)
        docker-compose logs -f postgres
        ;;
    
    psql)
        echo -e "${YELLOW}Connecting to PostgreSQL...${NC}"
        docker exec -it springlab-postgres psql -U springlab_user -d springlab_db
        ;;
    
    backup)
        BACKUP_FILE="backups/backup_$(date +%Y%m%d_%H%M%S).sql"
        echo -e "${YELLOW}Creating backup: ${BACKUP_FILE}${NC}"
        docker exec springlab-postgres pg_dump -U springlab_user springlab_db > ${BACKUP_FILE}
        echo -e "${GREEN}✅ Backup created!${NC}"
        ;;
    
    restore)
        if [ -z "$2" ]; then
            echo -e "${RED}Usage: $0 restore <backup_file>${NC}"
            exit 1
        fi
        echo -e "${YELLOW}Restoring from: $2${NC}"
        cat $2 | docker exec -i springlab-postgres psql -U springlab_user springlab_db
        echo -e "${GREEN}✅ Restore completed!${NC}"
        ;;
    
    clean)
        echo -e "${RED}⚠️  This will delete ALL data! Continue? (y/N)${NC}"
        read -r response
        if [[ "$response" =~ ^[Yy]$ ]]; then
            docker-compose down -v
            echo -e "${GREEN}✅ Cleaned up!${NC}"
        else
            echo -e "${YELLOW}Cancelled${NC}"
        fi
        ;;
    
    status)
        docker-compose ps
        ;;
    
    migrate)
        echo -e "${YELLOW}Running Flyway migrations...${NC}"
        ./mvnw flyway:migrate -Dspring.profiles.active=dev
        echo -e "${GREEN}✅ Migrations completed!${NC}"
        ;;
    
    *)
        echo "Usage: $0 {start|stop|logs|psql|backup|restore|clean|status|migrate}"
        exit 1
        ;;
esac