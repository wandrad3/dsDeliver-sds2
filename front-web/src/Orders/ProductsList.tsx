import { checkSelected } from "./Helpers";
import ProductCard from "./ProductCard";
import {Product} from './Types';
type Props = {
    products : Product[];
    selectedProducts : Product[];
    onSelectProduct: (product : Product) => void;
}
function ProductsList({products, onSelectProduct, selectedProducts} : Props){
    return(
        <div className="orders-list-container">
           <div className="orders-list-items">
                {
                    products.map( product => (
                        <ProductCard 
                        isSelected={checkSelected(selectedProducts, product)}

                            key={product.id} 
                            product={product}
                            onSelectProduct={onSelectProduct}
                        />
                    ))
                }
            </div>
        </div>
        

    )

}

export default ProductsList;