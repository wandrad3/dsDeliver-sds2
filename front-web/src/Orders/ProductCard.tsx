
import { formatPrice } from './Helpers';
import { Product } from './Types';

type Props = {
    product: Product;
    onSelectProduct: (product : Product) => void;
    isSelected: boolean;
}



function ProductCard({ product, onSelectProduct, isSelected }: Props) {
    return (
        <div className={`order-card-container ${isSelected ? 'selected' : ''}`}
            onClick= {()=> onSelectProduct(product)
            }>
            <h3 className="order-card-title">{product.name}</h3>
            <img alt={product.name} src={product.imageUri} className="order-card-image" />
            
            <h3 className="order-card-price">
                {formatPrice(product.price)}
            </h3>

            <div className="ordeer-card-description">
                {product.description}
            </div>


        </div>


    )

}

export default ProductCard;