package ui.bean;

import entity.Embalagem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "embalagemController")
@ViewScoped
public class EmbalagemController extends AbstractController<Embalagem> {

    @Inject
    private TipoMaterialController idMaterialController;
    @Inject
    private GrupoEmbalagemController idGrupoEmbalagemController;
    @Inject
    private CompatibilidadeController idCompatibilidadeController;
    @Inject
    private CapacidadeController idCapacidadeController;
    @Inject
    private ProdutoController produtoCollectionController;

    public EmbalagemController() {
        // Inform the Abstract parent controller of the concrete Embalagem?cap_first Entity
        super(Embalagem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMaterialController.setSelected(null);
        idGrupoEmbalagemController.setSelected(null);
        idCompatibilidadeController.setSelected(null);
        idCapacidadeController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoMaterial controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMaterial(ActionEvent event) {
        if (this.getSelected() != null && idMaterialController.getSelected() == null) {
            idMaterialController.setSelected(this.getSelected().getIdMaterial());
        }
    }

    /**
     * Sets the "selected" attribute of the GrupoEmbalagem controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdGrupoEmbalagem(ActionEvent event) {
        if (this.getSelected() != null && idGrupoEmbalagemController.getSelected() == null) {
            idGrupoEmbalagemController.setSelected(this.getSelected().getIdGrupoEmbalagem());
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
     * Sets the "selected" attribute of the Capacidade controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCapacidade(ActionEvent event) {
        if (this.getSelected() != null && idCapacidadeController.getSelected() == null) {
            idCapacidadeController.setSelected(this.getSelected().getIdCapacidade());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from Embalagem?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Produto page
     */
    public String navigateProdutoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Produto_items", this.getSelected().getProdutoCollection());
        }
        return "/entities/produto/index";
    }

}
