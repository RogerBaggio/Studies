import { useMutation } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import { useAuthContext } from '../stores/AuthContext';
import { loginApi, registerApi } from '../api/auth';
import type { LoginRequest } from '../types/auth';

export function useAuth() {
  const { login } = useAuthContext();
  const navigate = useNavigate();

  const loginMutation = useMutation({
    mutationFn: (data: LoginRequest) => loginApi(data),
    onSuccess: (response) => {
      login(response.accessToken, response.user);
      navigate('/products');
    },
    onError: (error: any) => {
      const message = error.response?.data?.message || 'Erro ao fazer login';
      throw new Error(message);
    },
  });

  const registerMutation = useMutation({
    mutationFn: (data: Parameters<typeof registerApi>[0]) => registerApi(data),
    onSuccess: (response) => {
      login(response.accessToken, response.user);
      navigate('/products');
    },
    onError: (error: any) => {
      const message = error.response?.data?.message || 'Erro ao registrar';
      throw new Error(message);
    },
  });

  return {
    login: loginMutation.mutate,
    register: registerMutation.mutate,
    isLoading: loginMutation.isPending || registerMutation.isPending,
    loginError: loginMutation.error?.message || null,
    registerError: registerMutation.error?.message || null,
  };
}