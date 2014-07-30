package ui.bean;

import entity.TipoSolicitacao;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoSolicitacaoController")
@ViewScoped
public class TipoSolicitacaoController extends AbstractController<TipoSolicitacao> {

    @Inject
    private FuncionarioController idFuncionarioController;
    @Inject
    private FornecedorController fornecedorIdFornecedorController;
    @Inject
    private ArmazemController idArmazemController;
    @Inject
    private MovimentacaoController movimentacaoCollectionController;

    public TipoSolicitacaoController() {
        // Inform the Abstract parent controller of the concrete TipoSolicitacao?cap_first Entity
        super(TipoSolicitacao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idFuncionarioController.setSelected(null);
        fornecedorIdFornecedorController.setSelected(null);
        idArmazemController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Funcionario controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdFuncionario(ActionEvent event) {
        if (this.getSelected() != null && idFuncionarioController.getSelected() == null) {
            idFuncionarioController.setSelected(this.getSelected().getIdFuncionario());
        }
    }

    /**
     * Sets the "selected" attribute of the Fornecedor controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFornecedorIdFornecedor(ActionEvent event) {
        if (this.getSelected() != null && fornecedorIdFornecedorController.getSelected() == null) {
            fornecedorIdFornecedorController.setSelected(this.getSelected().getFornecedorIdFornecedor());
        }
    }

    /**
     * Sets the "selected" attribute of the Armazem controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdArmazem(ActionEvent event) {
        if (this.getSelected() != null && idArmazemController.getSelected() == null) {
            idArmazemController.setSelected(this.getSelected().getIdArmazem());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Movimentacao entities
     * that are retrieved from TipoSolicitacao?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Movimentacao page
     */
    public String navigateMovimentacaoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Movimentacao_items", this.getSelected().getMovimentacaoCollection());
        }
        return "/entity/movimentacao/index";
    }

}
