package ui.bean;

import entity.NumOnu;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "numOnuController")
@ViewScoped
public class NumOnuController extends AbstractController<NumOnu> {

    @Inject
    private ProdutoController produtoCollectionController;

    public NumOnuController() {
        // Inform the Abstract parent controller of the concrete NumOnu?cap_first Entity
        super(NumOnu.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from NumOnu?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Produto page
     */
    public String navigateProdutoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Produto_items", this.getSelected().getProdutoCollection());
        }
        return "/entity/produto/index";
    }

}
