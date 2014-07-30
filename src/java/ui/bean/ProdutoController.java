package ui.bean;

import entity.Produto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "produtoController")
@ViewScoped
public class ProdutoController extends AbstractController<Produto> {

    @Inject
    private NumOnuController idNumOnuController;
    @Inject
    private NumCasController idNumCasController;
    @Inject
    private LegendaCompatibilidadeController idLegendaCompatibilidadeController;
    @Inject
    private EstFisicoController idEstFisicoController;
    @Inject
    private EndArmazemController idEndarmazemController;
    @Inject
    private EmbalagemController idEmbalagemController;
    @Inject
    private CompatibilidadeController idCompatibilidadeController;
    @Inject
    private ClasseController idClasseController;
    @Inject
    private ArmazemController armazemIdArmazemController;
    @Inject
    private MovimentacaoController movimentacaoCollectionController;
    @Inject
    private DetNotaController detNotaCollectionController;

    public ProdutoController() {
        // Inform the Abstract parent controller of the concrete Produto?cap_first Entity
        super(Produto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idNumOnuController.setSelected(null);
        idNumCasController.setSelected(null);
        idLegendaCompatibilidadeController.setSelected(null);
        idEstFisicoController.setSelected(null);
        idEndarmazemController.setSelected(null);
        idEmbalagemController.setSelected(null);
        idCompatibilidadeController.setSelected(null);
        idClasseController.setSelected(null);
        armazemIdArmazemController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the NumOnu controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdNumOnu(ActionEvent event) {
        if (this.getSelected() != null && idNumOnuController.getSelected() == null) {
            idNumOnuController.setSelected(this.getSelected().getIdNumOnu());
        }
    }

    /**
     * Sets the "selected" attribute of the NumCas controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdNumCas(ActionEvent event) {
        if (this.getSelected() != null && idNumCasController.getSelected() == null) {
            idNumCasController.setSelected(this.getSelected().getIdNumCas());
        }
    }

    /**
     * Sets the "selected" attribute of the LegendaCompatibilidade controller in
     * order to display its data in a dialog. This is reusing existing the
     * existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdLegendaCompatibilidade(ActionEvent event) {
        if (this.getSelected() != null && idLegendaCompatibilidadeController.getSelected() == null) {
            idLegendaCompatibilidadeController.setSelected(this.getSelected().getIdLegendaCompatibilidade());
        }
    }

    /**
     * Sets the "selected" attribute of the EstFisico controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEstFisico(ActionEvent event) {
        if (this.getSelected() != null && idEstFisicoController.getSelected() == null) {
            idEstFisicoController.setSelected(this.getSelected().getIdEstFisico());
        }
    }

    /**
     * Sets the "selected" attribute of the EndArmazem controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEndarmazem(ActionEvent event) {
        if (this.getSelected() != null && idEndarmazemController.getSelected() == null) {
            idEndarmazemController.setSelected(this.getSelected().getIdEndarmazem());
        }
    }

    /**
     * Sets the "selected" attribute of the Embalagem controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEmbalagem(ActionEvent event) {
        if (this.getSelected() != null && idEmbalagemController.getSelected() == null) {
            idEmbalagemController.setSelected(this.getSelected().getIdEmbalagem());
        }
    }

    /**
     * Sets the "selected" attribute of the Compatibilidade controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCompatibilidade(ActionEvent event) {
        if (this.getSelected() != null && idCompatibilidadeController.getSelected() == null) {
            idCompatibilidadeController.setSelected(this.getSelected().getIdCompatibilidade());
        }
    }

    /**
     * Sets the "selected" attribute of the Classe controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdClasse(ActionEvent event) {
        if (this.getSelected() != null && idClasseController.getSelected() == null) {
            idClasseController.setSelected(this.getSelected().getIdClasse());
        }
    }

    /**
     * Sets the "selected" attribute of the Armazem controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareArmazemIdArmazem(ActionEvent event) {
        if (this.getSelected() != null && armazemIdArmazemController.getSelected() == null) {
            armazemIdArmazemController.setSelected(this.getSelected().getArmazemIdArmazem());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Movimentacao entities
     * that are retrieved from Produto?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of DetNota entities that are
     * retrieved from Produto?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for DetNota page
     */
    public String navigateDetNotaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetNota_items", this.getSelected().getDetNotaCollection());
        }
        return "/entity/detNota/index";
    }

}
