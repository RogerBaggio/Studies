import { Link } from 'react-router-dom';

export function UnauthorizedPage() {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-50">
      <div className="text-center">
        <h1 className="text-6xl font-bold text-gray-300 mb-4">403</h1>
        <h2 className="text-xl font-semibold text-gray-700 mb-2">Acesso Negado</h2>
        <p className="text-gray-500 mb-6">Você não tem permissão para acessar esta página.</p>
        <Link to="/" className="text-indigo-600 hover:text-indigo-800">
          Voltar ao início
        </Link>
      </div>
    </div>
  );
}