package SGR;

public class Morador {
  
	private String nome;
	private String email;
	private float rendimento;

	public Morador(String nome, String email, float rendimento) {
		this.nome = nome;
		this.email = email;
		this.rendimento = rendimento;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getRendimento() {
		return rendimento;
	}

	public void setRendimento(float rendimento) {
		this.rendimento = rendimento;
	}

}
