package br.com.lanchonetegui;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		Pedido pedido = new Pedido();
		
		String codigo;
		String quantidade;
		String valorPago;
		
		double total = 0;
		int i = 0;
		double cont = 0.01;
		int qtdItem = 0;
		
		String [] nomePedido = new String[1000];
		int [] quantidadePedido = new int [1000];
		double [] precoPedido = new double [1000];
		int [] codigoPedido = new int [1000];
		
		Object [] inicio = {"Iniciar Pedido", "Sair"};
		Object selecionarInicio;
		Object [] opcao = { "Continuar com Pedido", "Finalizar Pedido"};
		Object selecionarOpcao;
		Object [] pagamento = {"Cartão", "Dinheiro"};
		Object selecionarPagamento;
			
			do {	
				
			selecionarInicio = JOptionPane.showInputDialog(null, "Bem-Vindo a Lanchonete Java\nSUPER PROMOÇÃO!\nPague com o cartão da Loja: \nReceba 20% de desconto no total da compra! \nEscolha a opção:", "Lanchonete Java - Início", JOptionPane.QUESTION_MESSAGE, null, inicio, inicio[0]);
			
			if (selecionarInicio == "Iniciar Pedido") {
			
			do {
			
				selecionarOpcao = JOptionPane.showInputDialog(null, "Selecione a opção:", "Lanchonete Java", JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
				
				if (selecionarOpcao == "Continuar com Pedido") {

			codigo = JOptionPane.showInputDialog(null, "Cardápio \n ================================= \n Especificação           Código          Preço \n Cachorro quente        100             3.50R$ \n Misto quente               101             2.50R$ \n X-Salada                      102             4.00R$ \n X-Tudo                          103             5.50R$ \n Pudim                           104              3.00R$ \n Refrigerante Lata      105              2.00R$  \n Refrigerante 2L          106              5.00R$ \n =================================\n    Código do produto:", "Lanchonete Java - Cardápio", JOptionPane.PLAIN_MESSAGE);
			
			quantidade = JOptionPane.showInputDialog(null, "Quantidade do ítem:", "Lanchonete Java", JOptionPane.QUESTION_MESSAGE);

			if(quantidade.isEmpty() || codigo.isEmpty()){
				JOptionPane.showMessageDialog(null,"Dados inválidos. Inicie um novo pedido.", "Lanchonete Java", JOptionPane.ERROR_MESSAGE, null);
			}
			
			else {
			
				pedido.setCodigo(Integer.parseInt(codigo));
				pedido.setQuantidade(Integer.parseInt(quantidade));
				
				if(pedido.getQuantidade() < 0) {
					JOptionPane.showMessageDialog(null,"Quantidade inválida. inicie um novo pedido.", "Lanchonete Java", JOptionPane.ERROR_MESSAGE, null);
					total = 0;
					nomePedido[i] = "";
					quantidadePedido[i] = 0; 
					precoPedido[i] = 0;
					codigoPedido[i] = 0 ;
					i =0;
					cont = i;
					qtdItem = 0;
				}
				
					else {	
		pedido.setPedido(codigo);
		total += pedido.calcularValor();
		nomePedido[i] = pedido.identificarPedido();
		quantidadePedido[i] = pedido.getQuantidade(); 
		precoPedido[i] = pedido.calcularValor();
		codigoPedido[i] = pedido.getCodigo();
		i++;
		cont = i;

				}
				}
				}
			
				else {				
					
				 selecionarPagamento = JOptionPane.showInputDialog(null, "Forma de pagamento:", "Lanchonete Java - Forma de Pagamento", JOptionPane.QUESTION_MESSAGE, null, pagamento, pagamento[0]);
				 
				 if(selecionarPagamento == "Cartão") {
					 	
					 i=0;
					 
					 for ( int j = 0; j < cont; j++) {
						 
						 for (int x = 0; x < cont; x++) {
								qtdItem += quantidadePedido[i];		
							}
						 
							JOptionPane.showMessageDialog(null, "          Compra finalizada \n===========================\nCódigo: " + codigoPedido[i] + "\nÍtem: " + nomePedido[i]  + " \nQuantidade: " + quantidadePedido[i] +" \nValor Unitário: "+ String.format("%.2f" , (precoPedido[i]/quantidadePedido[i])) + " R$\nTotal Parcial: " + String.format("%.2f" , precoPedido[i]) + " R$\n===========================", "Lanchonete Java - Nota Fiscal", JOptionPane.PLAIN_MESSAGE, null);
							i++;
							
					 }
					 
					 JOptionPane.showMessageDialog(null, "LANCHONETE JAVA Ltda.\nNota Fiscal Fiscal \n=====================================\n\n\nQTD TOTAL DE ITENS:                                 "  + String.format("%.0f", qtdItem/cont) +   "\nDESCONTOS:                                           " + String.format("%.2f" , 0.2*total) + " R$\n"+"VALOR TOTAL:                                        "  + String.format("%.2f", total) +" R$"  +"\nVALOR TOTAL COM DESCONTOS:     "  + String.format("%.2f" , (total - (0.2*total))) +" R$\n\nFORMA DE PAGAMENTO:     " + selecionarPagamento +"\nVALOR PAGO:                        "+ String.format("%.2f" , (total - (0.2*total))) +" R$\nTROCO:                                    0,00 R$\n\n\n===================================== \n                      GitHub: fCrispim3", "Lanchonete Java - Nota Fiscal", JOptionPane.PLAIN_MESSAGE, null);
				 
				 }
				 
				 else {
					 
					 valorPago = JOptionPane.showInputDialog(null, "Total : " + total +"R$\nValor Pago:", "Lanchonete Java", JOptionPane.QUESTION_MESSAGE);
					 if (valorPago.isEmpty()) {

							JOptionPane.showMessageDialog(null,"Valor Insuficiente. Inicie um novo pedido.", "Lanchonete Java", JOptionPane.ERROR_MESSAGE, null);
					 }
					 else {
					 valorPago = valorPago.replace(",", ".");
					 pedido.setValorPago(Double.parseDouble(valorPago));
					 
					 if(pedido.getValorPago() < total) {
							JOptionPane.showMessageDialog(null,"Valor Insuficiente. Inicie um novo pedido.", "Lanchonete Java", JOptionPane.ERROR_MESSAGE, null);
						}
					 else {
						 
					 i=0;
					 
					 for ( int j = 0; j < cont; j++) {
						 		 
						 for (int x = 0; x < cont; x++) {
								qtdItem += quantidadePedido[i];		
							}
						 JOptionPane.showMessageDialog(null, "          Compra finalizada \n===========================\nCódigo: " + codigoPedido[i] + "\nÍtem: " + nomePedido[i]  + " \nQuantidade: " + quantidadePedido[i] +" \nValor Unitário: "+ String.format("%.2f" , (precoPedido[i]/quantidadePedido[i])) + " R$\nTotal Parcial: " + String.format("%.2f" , precoPedido[i]) + " R$\n===========================", "Lanchonete Java - Nota Fiscal", JOptionPane.PLAIN_MESSAGE, null);
						 i++;
					 }
						 
					 JOptionPane.showMessageDialog(null, "LANCHONETE JAVA Ltda.\nNota Fiscal Fiscal \n================================\n\n\nQTD TOTAL DE ITENS:                                 "  + String.format("%.0f", qtdItem/cont) +    "\nDESCONTOS:                                           0,00 R$\nVALOR TOTAL:                                        "  + String.format("%.2f", total) +" R$"  +"\nVALOR TOTAL COM DESCONTOS:     "  + String.format("%.2f", total)  +" R$\n\nFORMA DE PAGAMENTO:     " + selecionarPagamento +"\nVALOR PAGO:                        "+ pedido.getValorPago() +" R$\nTROCO:                                    "+ String.format("%.2f" , pedido.getValorPago() - total) +" R$\n\n\n================================\n                      GitHub: fCrispim3", "Lanchonete Java - Nota Fiscal", JOptionPane.PLAIN_MESSAGE, null);
					 }
					 }
				 }
				}
			}while(selecionarOpcao != "Finalizar Pedido");	
			
			total = 0;
			nomePedido[i] = "";
			quantidadePedido[i] = 0; 
			precoPedido[i] = 0;
			codigoPedido[i] = 0 ;
			i =0;
			cont = i;
			qtdItem = 0;
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Sistema desenvolvido por Felipe Crispim.\n                   GitHub : fCrispim3", "Lanchonete Java", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			
	}while(selecionarInicio != "Sair");
	}		
}
	
