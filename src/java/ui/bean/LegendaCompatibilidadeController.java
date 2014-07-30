package ui.bean;

import entity.LegendaCompatibilidade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "legendaCompatibilidadeController")
@ViewScoped
public class LegendaCompatibilidadeController extends AbstractController<LegendaCompatibilidade> {

    @Inject
    private ProdutoController produtoCollectionController;
    @Inject
    private CompatibilidadeController compatibilidadeCollectionController;

    public LegendaCompatibilidadeController() {
        // Inform the Abstract parent controller of the concrete LegendaCompatibilidade?cap_first Entity
        super(LegendaCompatibilidade.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from LegendaCompatibilidade?cap_first and returns the
     * navigation outcome.
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
     * Sets the "items" attribute with a collection of Compatibilidade entities
     * that are retrieved from LegendaCompatibilidade?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Compatibilidade page
     */
    public String navigateCompatibilidadeCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Compatibilidade_items", this.getSelected().getCompatibilidadeCollection());
        }
        return "/entity/compatibilidade/index";
    }

}
