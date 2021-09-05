import { Product } from "./Types";

export function checkSelected(selectedProducts : Product[], product : Product){
    return selectedProducts.some(item => item.id === product.id);
}

export function formatPrice(price: number) {
    const formatter = new Intl.NumberFormat('pt-br', {
        style: 'currency',
        currency: 'BRL',
        minimumFractionDigits: 2

    })
    return formatter.format(price)
}