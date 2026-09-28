package trabalho.pkg02;

import java.util.UUID;

// IFSP CBT ADS 2026 - Linguagem de Programação 2
// Aluno: Felipe Barretto
public class Aluno
{
    private UUID uuid;
    private String nome;
    private int idade;
    private String endereco;

    public UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(UUID uuid)
    {
        this.uuid = uuid;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }
}
