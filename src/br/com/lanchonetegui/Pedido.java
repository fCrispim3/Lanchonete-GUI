package br.com.lanchonetegui;

public class Pedido implements InterfaceLanchonete {

	private int codigo;
	private int quantidade;
	private double preco;
	private String pedido;
	private String formaPagamento;
	private double valorPago;
	
	
	public Pedido() {
		// TODO Auto-generated constructor stub

	}

	/*public static int contarItens(int x []) {
		int i, n = x.length, sm =0;
		for(i = 0; i < n; i++) {
			sm = sm + x[i];
		}
		return sm;
	}*/
	
	@Override
	public double calcularValor() {
		
		if ( this.codigo == 100) {
			this.preco = 3.50;
			return this.preco * this.quantidade;
		}
		
		else if (this.codigo == 101) {
			this.preco = 2.50;
			return this.preco * this.quantidade;
		}
		
		else if (this.codigo == 102) {
			this.preco = 4.00;
			return this.preco * this.quantidade;
		}

		else if (this.codigo == 103) { 
			this.preco = 5.50;
			return this.preco * this.quantidade;
		}

		else if (this.codigo == 104) {
			this.preco = 3.00;
			return this.preco * this.quantidade;
		}

		else if (this.codigo == 105) {
			this.preco = 2.00;
			return this.preco * this.quantidade;
		}

		else if ( this.codigo == 106) {
			this.preco = 5.00;	
			return this.preco * this.quantidade;
		}
		
		else {
		return 0;	
		}
	}

	

	@Override
	public String identificarPedido() {
		if ( this.codigo == 100) 
			this.pedido = "Cachorro Quente";

		else if (this.codigo == 101)
			this.pedido = "Misto quente";
		
		else if (this.codigo == 102) 
			this.pedido = "X-Salada";
		
		else if (this.codigo == 103) 
			this.pedido = "X-Tudo";
		
		else if (this.codigo == 104) 
			this.pedido  = "Pudim";

		else if (this.codigo == 105) 
			this.pedido = "Refrigerante Lata";
			
		else if ( this.codigo == 106) 
			this.pedido = "Refrigerante 2L";
		
		else {
			this.pedido = "Não Cadastrado";
		}
		return this.pedido;
	}
	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

}
