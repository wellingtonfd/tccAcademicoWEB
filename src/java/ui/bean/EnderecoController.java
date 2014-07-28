package ui.bean;

import entity.Endereco;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "enderecoController")
@ViewScoped
public class EnderecoController extends AbstractController<Endereco> {

    @Inject
    private FornecedorController fornecedorCollectionController;
    @Inject
    private FuncionarioController funcionarioCollectionController;
    @Inject
    private PaisController idPaisController;
    @Inject
    private EstadoController idEstadoController;
    @Inject
    private CidadeController idCidadeController;

    public EnderecoController() {
        // Inform the Abstract parent controller of the concrete Endereco?cap_first Entity
        super(Endereco.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPaisController.setSelected(null);
        idEstadoController.setSelected(null);
        idCidadeController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Fornecedor entities that
     * are retrieved from Endereco?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Fornecedor page
     */
    public String navigateFornecedorCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Fornecedor_items", this.getSelected().getFornecedorCollection());
        }
        return "/entities/fornecedor/index";
    }

    /**
     * Sets the "items" attribute with a collection of Funcionario entities that
     * are retrieved from Endereco?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Funcionario page
     */
    public String navigateFuncionarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Funcionario_items", this.getSelected().getFuncionarioCollection());
        }
        return "/entities/funcionario/index";
    }

    /**
     * Sets the "selected" attribute of the Pais controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPais(ActionEvent event) {
        if (this.getSelected() != null && idPaisController.getSelected() == null) {
            idPaisController.setSelected(this.getSelected().getIdPais());
        }
    }

    /**
     * Sets the "selected" attribute of the Estado controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEstado(ActionEvent event) {
        if (this.getSelected() != null && idEstadoController.getSelected() == null) {
            idEstadoController.setSelected(this.getSelected().getIdEstado());
        }
    }

    /**
     * Sets the "selected" attribute of the Cidade controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCidade(ActionEvent event) {
        if (this.getSelected() != null && idCidadeController.getSelected() == null) {
            idCidadeController.setSelected(this.getSelected().getIdCidade());
        }
    }
}
