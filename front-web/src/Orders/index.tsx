import { useEffect, useState } from 'react';
import { fetchProducts, saveOrder } from '../api';
import { toast } from 'react-toastify';
import Footer from '../Footer';
import { checkSelected } from './Helpers';
import OrderLocation from './OrderLocation';
import OrderSummary from './OrderSummary';
import ProductsList from './ProductsList';
import StepsHeader from './StepsHeader';
import './styles.css'
import { OrderLocationData, Product } from './Types';

function Orders() {

    const [products, setProducts] = useState<Product[]>([]);
    const [selectedProducts, setSelectedProducts] = useState<Product[]>([]);
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();
    const totalPrice = selectedProducts.reduce((sum, item) =>{
        return sum + item.price;
    },0 )
    useEffect(() => {
        fetchProducts()
            .then(response => setProducts(response.data))
            .catch((error => error))
    }, [])

    const handleSelectProduct = (product: Product) => {
        const isAlreadySelected = checkSelected(selectedProducts,product);

        if (isAlreadySelected) {
            const selected = selectedProducts.filter(item => item.id !== product.id);
            setSelectedProducts(selected);
        } else {
            setSelectedProducts(previous => [...previous, product]);
        }
    }

    const handleSubmit = () => {
        const productsIds = selectedProducts.map(({ id }) => ({ id }));
        const payload = {
          ...orderLocation!,
          products: productsIds
        }
      
        saveOrder(payload).then((response) => {
          toast.error(`Pedido enviado com sucesso! N° ${response.data.id}`);
          setSelectedProducts([]);
        })
          .catch(() => {
            toast.warning('Erro ao enviar pedido');
          })
      }

    return (
        <>
            <div className="orders-container">
                <StepsHeader />

                <ProductsList
                    products={products}
                    selectedProducts={selectedProducts}
                    onSelectProduct={handleSelectProduct} />
                <OrderLocation onChangeLocation={location => setOrderLocation(location)} />
                <OrderSummary 
                        onSubmit={handleSubmit}
                        amount={selectedProducts.length} totalPrice={totalPrice} />
                <Footer />
            </div>
        </>


    )

}

export default Orders;