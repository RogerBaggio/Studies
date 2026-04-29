import { Navigate, Outlet, useLocation } from 'react-router-dom';
import { useAuthContext } from '../stores/AuthContext';

interface Props {
  requiredPermissions?: string[];
  requiredRoles?: string[];
}

export function ProtectedRoute({ requiredPermissions, requiredRoles }: Props) {
  const { isAuthenticated, user } = useAuthContext();
  const location = useLocation();

  if (!isAuthenticated) {
    return <Navigate to="/login" state={{ from: location }} replace />;
  }

  // Verificação de permissões
  if (requiredPermissions && user) {
    const hasPermission = requiredPermissions.some(p => user.permissions.includes(p));
    if (!hasPermission) {
      return <Navigate to="/unauthorized" replace />;
    }
  }

  // Verificação de roles
  if (requiredRoles && user) {
    const hasRole = requiredRoles.some(r => user.roles.includes(r));
    if (!hasRole) {
      return <Navigate to="/unauthorized" replace />;
    }
  }

  return <Outlet />;
}