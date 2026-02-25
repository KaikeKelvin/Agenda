import Agenda.AgendaDao;
import Agenda.AgendaModel;
import static java.lang.System.in;

void main() {

    AgendaDao dao = new AgendaDao();
    System.out.println("Olá o que você deseja fazer?");
    Scanner ler = new Scanner(in);
    String opcao = "";

    while(!opcao.equalsIgnoreCase("sair")){
        System.out.println("1-inserir \n 2-buscar \n 3-sair"  );
        opcao = ler.nextLine();
        switch (opcao){
            case "inserir":
                System.out.println("digite o nome");
                String nome = ler.nextLine();
                System.out.println("digite o email");
                String email = ler.nextLine();
                System.out.println("digite o telefone");
                String tel = ler.nextLine();

                try {
                    AgendaModel novoContato = new AgendaModel();
                    novoContato.setNome(nome);
                    novoContato.setEmail(email);
                    novoContato.setTelefone(tel);

                    dao.inserir(novoContato);
                    System.out.println("Salvo com sucesso!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "buscar":
                try {
                        List<AgendaModel> contatos = dao.buscar();

                        if(contatos.isEmpty()) {
                            System.out.println("Nenhum contato encontrado.");
                        } else {
                            for (AgendaModel c : contatos) {
                                System.out.println("ID: " + c.getId() +
                                        " | Nome: " + c.getNome() +
                                        " | Tel: " + c.getTelefone());
                            }
                        }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("saindo");
                break;


        }
    }
}