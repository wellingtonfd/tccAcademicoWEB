/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.factory;

import entity.Compatibilidade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Stateless
public class CompatibilidadeFacade extends AbstractFacade<Compatibilidade> {
    @PersistenceContext(unitName = "tccAcademicoWEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompatibilidadeFacade() {
        super(Compatibilidade.class);
    }

}
