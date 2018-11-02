package burgerapp.components.burger;

import burgerapp.components.generic.GenericDaoImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class BurgerDaoImpl extends GenericDaoImpl<Burger, Long> implements BurgerDao
{
    public Optional<Burger> findByName(String name)
    {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.name LIKE :name", Burger.class);
        List<Burger> list = query.setParameter("name", name).getResultList();
        return list.size() > 0 ? Optional.ofNullable(list.get(0)) : Optional.empty();
    }
}