package com.example.czxt;

import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RandSort ran = new RandSort();
        String id = request.getParameter("id");
        int[] sort={0};
        if(Integer.parseInt(id)==0) {
            sort=ran.rand();
        }
        else if(Integer.parseInt(id)==1)
        {
            String charbs = request.getParameter("charb");
            int[] charb=ran.stringcl(charbs);
            sort=charb;
        }
        int[] rand=new int[sort.length];
        int[] sht=new int[sort.length];
        int[] scal=new int[sort.length];
        int[] scar=new int[sort.length];
        int[] cscal=new int[sort.length];
        int[] cscar=new int[sort.length];
        for (int i=0;i<sort.length;i++)
        {
            rand[i]=sort[i];
            sht[i]=sort[i];
            scal[i]=sort[i];
            scar[i]=sort[i];
            cscal[i]=sort[i];
            cscar[i]=sort[i];
        }
        sort = ran.sort(sort);
        sht = ran.shortest(sht);
        scal = ran.scan(scal,"l");
        scar = ran.scan(scar,"r");
        cscal =ran.cscan(cscal,"l");
        cscar =ran.cscan(cscar,"r");
        ran.setRan(rand);
        ran.setSor(sort);
        ran.setSht(sht);
        ran.setScal(scal);
        ran.setScar(scar);
        ran.setCscal(cscal);
        ran.setCscar(cscar);

        String jsonString = JSON.toJSONString(ran);
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
