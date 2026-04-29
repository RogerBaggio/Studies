import apiClient from './client';
import type { LoginRequest, LoginResponse } from '../types/auth';

export async function loginApi(data: LoginRequest): Promise<LoginResponse> {
  const response = await apiClient.post<LoginResponse>('/auth/login', data);
  return response.data;
}

export async function registerApi(data: {
  fullName: string;
  email: string;
  password: string;
  phone?: string;
}): Promise<LoginResponse> {
  const response = await apiClient.post<LoginResponse>('/auth/register', data);
  return response.data;
}