
import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class TestePessoa
{
    private Pessoa pessoa;
    
    @Before
    public void setUp() {
        pessoa = new Pessoa("Mateus", "Silva", 1960);
    }

    @Test
    public void devePermitirAlterarOsAtributos() {
    	pessoa.setNome("Rafaela");
    	pessoa.setSobrenome("Virmond");
    	pessoa.setAnoDeNascimento(1964);
    	
    	assertEquals("Rafaela", pessoa.getNome());
        assertEquals("Virmond", pessoa.getSobrenome());
        assertEquals(pessoa.getAnoDeNascimento(), 1964);
    }
    
    @Test
    public void deveRetornarONomeCompleto() {
        assertEquals("Mateus", pessoa.getNome());
        assertEquals("Silva", pessoa.getSobrenome());
        
        assertEquals("Mateus Silva", pessoa.getNomeCompleto());
    }
    
    @Test
    public void deveRetornarAIdade() {
        assertEquals(57, pessoa.getIdade());
    }
    
    @Test
    public void deveRetornarAIdadeEmMeses() {
        assertEquals(57*12, pessoa.getIdadeEmMeses());
    }
    
    @Test
    public void deveRemoverOsEspacosAntesEDepoisDaStringQuandoAlteradoPelosMetodosModificadores() {
    	pessoa.setNome(" Rafaela  ");
    	pessoa.setSobrenome("  Virmond      ");
    	
    	assertEquals("Rafaela", pessoa.getNome());
        assertEquals("Virmond", pessoa.getSobrenome());
        assertEquals("Rafaela Virmond", pessoa.getNomeCompleto());
    }
    
    @Test
    public void deveRemoverOsEspacosAntesEDepoisDaStringQuandoInstanciado() {
    	pessoa = new Pessoa(" Rafaela  ", "  Virmond      ", 1964);
    	
    	assertEquals("Rafaela", pessoa.getNome());
        assertEquals("Virmond", pessoa.getSobrenome());
        assertEquals("Rafaela Virmond", pessoa.getNomeCompleto());
    }
    
    @Test
    public void naoDeveAceitarValoresVaziosParaONomeESobrenome() {
    	pessoa.setNome("  ");
    	pessoa.setSobrenome("      ");
    	
    	assertEquals("Mateus", pessoa.getNome());
        assertEquals("Silva", pessoa.getSobrenome());
        
        assertEquals("Mateus Silva", pessoa.getNomeCompleto());
    }
    
    @Test
    public void naoDeveAceitarValoresEmBrancoNaInstanciacao() {
    	pessoa = new Pessoa("   ", "       ", 1964);
    	
    	assertEquals("<Não informado>", pessoa.getNome());
        assertEquals("<Não informado>", pessoa.getSobrenome());
        assertEquals("<Não informado> <Não informado>", pessoa.getNomeCompleto());
       
    }
    
    @Test
    public void deveCapitalizarONomeESobrenome() {
    	pessoa.setNome("rafaela");
    	pessoa.setSobrenome("virmond");
    	pessoa.setAnoDeNascimento(1964);
    	
    	assertEquals("Rafaela", pessoa.getNome());
        assertEquals("Virmond", pessoa.getSobrenome());
        assertEquals("Rafaela Virmond", pessoa.getNomeCompleto());
        
        pessoa = new Pessoa("mateus", "silva", 1960);
        assertEquals("Mateus Silva", pessoa.getNomeCompleto());
    }
    
    @Test
    public void deveTerMaisDeTresCaracteres() {
    	pessoa.setNome("ra");
    	pessoa.setSobrenome("vi");
    	
    	assertEquals("Mateus", pessoa.getNome());
        assertEquals("Silva", pessoa.getSobrenome());
        assertEquals("Mateus Silva", pessoa.getNomeCompleto());
        
        pessoa = new Pessoa("ma", "ca", 1960);
        assertEquals("<Não informado>", pessoa.getNome());
        assertEquals("<Não informado>", pessoa.getSobrenome());
        assertEquals("<Não informado> <Não informado>", pessoa.getNomeCompleto());
    }
    
    @Test
    public void naoDeveAceitaValoresMaioresQueADataAtualParaOAnoDeNascimento() {
    	int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
    	
    	pessoa.setAnoDeNascimento(anoAtual);
    	assertEquals(pessoa.getAnoDeNascimento(), anoAtual);
    	
    	pessoa.setAnoDeNascimento(2018);
    	assertEquals(2017,pessoa.getAnoDeNascimento());
    }
    
}