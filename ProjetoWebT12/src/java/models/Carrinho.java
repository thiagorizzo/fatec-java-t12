package models;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<ProdutoCarrinho> produtos;

    public ArrayList<ProdutoCarrinho> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ProdutoCarrinho> produtos) {
        this.produtos = produtos;
    }
}
