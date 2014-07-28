package ui.bean;

import entity.Classe;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "classeController")
@ViewScoped
public class ClasseController extends AbstractController<Classe> {

    @Inject
    private ProdutoController produtoCollectionController;

    public ClasseController() {
        // Inform the Abstract parent controller of the concrete Classe?cap_first Entity
        super(Classe.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from Classe?cap_first and returns the navigation outcome.
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
