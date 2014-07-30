package ui.bean;

import entity.Estado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "estadoController")
@ViewScoped
public class EstadoController extends AbstractController<Estado> {

    @Inject
    private EnderecoController enderecoCollectionController;

    public EstadoController() {
        // Inform the Abstract parent controller of the concrete Estado?cap_first Entity
        super(Estado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Endereco entities that
     * are retrieved from Estado?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Endereco page
     */
    public String navigateEnderecoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Endereco_items", this.getSelected().getEnderecoCollection());
        }
        return "/entity/endereco/index";
    }

}
