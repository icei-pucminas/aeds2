class Cliente {
	private int codigo;
	private String nome;
	public Cliente (){
		this.codigo = 0;			this.nome = "";
	}
	public Cliente (int codigo, String nome){
		this.codigo = codigo;	this.nome = nome;
	}
	public int getCodigo(){				    	return codigo;			}
	public void setCodigo(int codigo){	this.codigo = codigo;	}
	public String getNome(){			     	return nome;				}
	public void setNome(String nome){  	this.nome = nome;		}

   public Cliente clone (){
		Cliente resp = new Cliente();
		resp.codigo = this.codigo;
		resp.nome = this.nome;
		return resp;
	}

}

