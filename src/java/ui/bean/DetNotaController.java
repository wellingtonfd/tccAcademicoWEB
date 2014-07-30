package ui.bean;

import entity.DetNota;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detNotaController")
@ViewScoped
public class DetNotaController extends AbstractController<DetNota> {

    @Inject
    private MovimentacaoController movimentacaoCollectionController;
    @Inject
    private TipoEquipamentoController tipoEquipamentoIdTipoEquipamentoController;
    @Inject
    private ProdutoController idProdutoController;
    @Inject
    private FornecedorController fornecedorIdFornecedorController;

    public DetNotaController() {
        // Inform the Abstract parent controller of the concrete DetNota?cap_first Entity
        super(DetNota.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tipoEquipamentoIdTipoEquipamentoController.setSelected(null);
        idProdutoController.setSelected(null);
        fornecedorIdFornecedorController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Movimentacao entities
     * that are retrieved from DetNota?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Movimentacao page
     */
    public String navigateMovimentacaoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Movimentacao_items", this.getSelected().getMovimentacaoCollection());
        }
        return "/entity/movimentacao/index";
    }

    /**
     * Sets the "selected" attribute of the TipoEquipamento controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoEquipamentoIdTipoEquipamento(ActionEvent event) {
        if (this.getSelected() != null && tipoEquipamentoIdTipoEquipamentoController.getSelected() == null) {
            tipoEquipamentoIdTipoEquipamentoController.setSelected(this.getSelected().getTipoEquipamentoIdTipoEquipamento());
        }
    }

    /**
     * Sets the "selected" attribute of the Produto controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdProduto(ActionEvent event) {
        if (this.getSelected() != null && idProdutoController.getSelected() == null) {
            idProdutoController.setSelected(this.getSelected().getIdProduto());
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
}
