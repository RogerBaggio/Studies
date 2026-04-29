export interface Product {
  id: number;
  sku: string;
  name: string;
  description: string;
  price: number;
  category: string;
  stockQuantity: number;
  active: boolean;
  createdAt: string;
  updatedAt: string;
  available: boolean;
  priceFormatted: string;
}

export interface ProductRequest {
  sku: string;
  name: string;
  description?: string;
  price: number;
  category?: string;
  stockQuantity?: number;
}