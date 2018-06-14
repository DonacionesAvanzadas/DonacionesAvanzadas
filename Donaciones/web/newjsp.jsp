<%-- 
    Document   : newjsp
    Created on : 5/06/2018, 09:53:03 PM
    Author     : Yael Arturo Chavoya Andalón 14300094
--%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="entities.*"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DonacionesPU");
            EntityManager em = emf.createEntityManager();
           %>
           <%--
               Query q = em.createQuery("SELECT u FROM Usuario u  WHERE u.id = 2");
               List<Usuario> results = q.getResultList();
               for(Usuario u : results){
                   out.println(u.getNombre() + "<br>");
               }
           --%>
           <%
            Usuario usuario = new Usuario();
            usuario.setId(3);
            usuario.setCorreo("mi@user.com");
            usuario.setDenuncias(0);
            usuario.setNombreUsuario("user");
            usuario.setNombre("Usuario");
            usuario.setPassword("123");
            usuario.setEstado(true);
            usuario.setEstrellas(0);
            usuario.setTipoUsuario("Regular");
            usuario.setImagen("");
            /*
            Categoria cat = new Categoria();
            cat.setNombre("Libros");
            cat.setEstado(true);
            */
            em.getTransaction().begin();
            em.persist(usuario);
            /*em.persist(cat);*/
            em.getTransaction().commit();

            %>
    </body>
</html>
