package modulo02.aula01;


    public class Main {
        public static void main(String[] args) {
            Contato contato1 = new Contato("João", "123456789");
            Contato contato2 = new Contato("Maria", "987654321");
            Contato contato3 = new Contato("Carlos", "555555555");

            Agenda agenda = new Agenda();
            agenda.adicionar(contato1);
            agenda.adicionar(contato2);
            agenda.adicionar(contato3);

            Contato contatoEncontrado = agenda.buscar("Maria");
            if (contatoEncontrado != null) {
                contatoEncontrado.ligar();
            } else {
                System.out.println("Contato não encontrado");
            }

            contato2.detalhar();
            System.out.println("Número de Carlos: " + contato3.verNumero());

            agenda.deletar(contato1);

            Contato contatoDeletado = agenda.buscar("João");
            if (contatoDeletado != null) {
                System.out.println("Contato encontrado: " + contatoDeletado.getNome());
            } else {
                System.out.println("Contato não encontrado");
            }
        }
    }
