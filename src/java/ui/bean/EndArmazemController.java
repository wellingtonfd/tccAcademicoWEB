package ui.bean;

import entity.EndArmazem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "endArmazemController")
@ViewScoped
public class EndArmazemController extends AbstractController<EndArmazem> {

    @Inject
    private ProdutoController produtoCollectionController;
    @Inject
    private MovimentacaoController movimentacaoCollectionController;
    @Inject
    private ArmazemController armazemCollectionController;

    public EndArmazemController() {
        // Inform the Abstract parent controller of the concrete EndArmazem?cap_first Entity
        super(EndArmazem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from EndArmazem?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Movimentacao entities
     * that are retrieved from EndArmazem?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Armazem entities that are
     * retrieved from EndArmazem?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Armazem page
     */
    public String navigateArmazemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Armazem_items", this.getSelected().getArmazemCollection());
        }
        return "/entity/armazem/index";
    }

}
