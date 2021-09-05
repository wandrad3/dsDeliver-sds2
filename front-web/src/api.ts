import axios from "axios";
import { OrderPayLoad } from "./Orders/Types";
const API_URL= process.env.REACT_APP_API_URL;
//const API_URL= "http://localhost:8080";
//const mapboxToken  = "pk.eyJ1Ijoid2VzbGV5YW5kcmFkZSIsImEiOiJja2pwMXRmODEwY3MxMndteWo1NDVqYWlkIn0.4c24XiKA8c7BqOKFGbpRcQ"
const mapboxToken = process.env.REACT_APP_ACCESS_TOKEN_MAP_BOX;

export function fetchProducts(){
    return axios(`${API_URL}/products`)

}

export function fetchLocalMapBox(local:string){
    return axios( `https://api.mapbox.com/geocoding/v5/mapbox.places/${local}.json?access_token=${mapboxToken}`);

}
export function saveOrder(payload : OrderPayLoad){
    return axios.post(`${API_URL}/orders`, payload);

}