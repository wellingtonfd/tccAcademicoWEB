package ui.bean;

import entity.StatusArmazem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "statusArmazemController")
@ViewScoped
public class StatusArmazemController extends AbstractController<StatusArmazem> {

    @Inject
    private ArmazemController armazemCollectionController;

    public StatusArmazemController() {
        // Inform the Abstract parent controller of the concrete StatusArmazem?cap_first Entity
        super(StatusArmazem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Armazem entities that are
     * retrieved from StatusArmazem?cap_first and returns the navigation
     * outcome.
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
