package br.sge.segurancaDAO;

import dao.BaseDAO;
import java.util.List;
import model.TbUsuario;
import org.hibernate.Query;

/**
 *
 * @author alex
 */
public class TbUsuarioDAO extends BaseDAO<TbUsuario> {

    public List<TbUsuario> consultarLoginSenha(String loginUsuario, String senhaUsuario) {
        List<TbUsuario> lista;
        Query qy = hib.createQuery("SELECT obj FROM TbUsuario obj "
                + "WHERE loginUsuario=? AND senhaUsuario = ?");

        qy.setString(0, loginUsuario);
        qy.setString(1, senhaUsuario);
        lista = qy.list();
        return lista;
    }
}
