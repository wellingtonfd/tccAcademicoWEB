package ui.bean;

import entity.Compatibilidade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "compatibilidadeController")
@ViewScoped
public class CompatibilidadeController extends AbstractController<Compatibilidade> {

    @Inject
    private EmbalagemController embalagemCollectionController;
    @Inject
    private ProdutoController produtoCollectionController;
    @Inject
    private LegendaCompatibilidadeController idLegendaCompatibilidadeController;

    public CompatibilidadeController() {
        // Inform the Abstract parent controller of the concrete Compatibilidade?cap_first Entity
        super(Compatibilidade.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idLegendaCompatibilidadeController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Embalagem entities that
     * are retrieved from Compatibilidade?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Embalagem page
     */
    public String navigateEmbalagemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Embalagem_items", this.getSelected().getEmbalagemCollection());
        }
        return "/entity/embalagem/index";
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from Compatibilidade?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Produto page
     */
    public String navigateProdutoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Produto_items", this.getSelected().getProdutoCollection());
        }
        return "/entity/produto/index";
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
}
