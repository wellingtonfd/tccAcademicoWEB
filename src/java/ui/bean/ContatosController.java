package ui.bean;

import entity.Contatos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "contatosController")
@ViewScoped
public class ContatosController extends AbstractController<Contatos> {

    @Inject
    private FornecedorController fornecedorCollectionController;
    @Inject
    private FuncionarioController funcionarioCollectionController;

    public ContatosController() {
        // Inform the Abstract parent controller of the concrete Contatos?cap_first Entity
        super(Contatos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Fornecedor entities that
     * are retrieved from Contatos?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Fornecedor page
     */
    public String navigateFornecedorCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Fornecedor_items", this.getSelected().getFornecedorCollection());
        }
        return "/entity/fornecedor/index";
    }

    /**
     * Sets the "items" attribute with a collection of Funcionario entities that
     * are retrieved from Contatos?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Funcionario page
     */
    public String navigateFuncionarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Funcionario_items", this.getSelected().getFuncionarioCollection());
        }
        return "/entity/funcionario/index";
    }

}
