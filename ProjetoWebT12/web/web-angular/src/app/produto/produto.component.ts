import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component(
    {
        selector: "listar-produtos",
        templateUrl: "produto.component.html"
    }
)
export class ListarProdutoComponent implements OnInit
{
    private produtos : Produto[];

    constructor(private http : HttpClient) {
    }

    ngOnInit(): void {
        this.getProdutos();
    }

    public getProdutos() {
        this.http.get<Produto[]>("http://localhost:8084/ProjetoWebT12/api/Produto/")
                .subscribe(
                    (data) => {
                        this.produtos = data;
                    },
                    (error) => {

                    });
    }
}