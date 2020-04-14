import axios from 'axios'

const LOJA = 'E-COMMERCE'
const LOJA_API_URL = 'http://localhost:8080'
const LOJA_API_URL = `${PRODUTO_API_URL}/lojas/${LOJA}`

class ProdutoDataService {

    retrieveAllProdutos(name) {
        return axios.get(`${LOJA_API_URL}/produtos`);
    }
}

export default new ProdutoDataService()