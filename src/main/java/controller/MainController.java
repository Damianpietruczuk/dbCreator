package controller;

import database.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private Connection connection = new SQLConnection().getConnection();
    private List<String> columns= new ArrayList<>();
    private CRUDStatementSQL crudStatementSQL= new CRUDStatementSQL(connection);
    private MetaData metaData = new MetaData();
    private Map<List<String>,List<String>> table = new HashMap<>();

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/create")
    public ModelAndView create(){return new ModelAndView("create","command", new Table());
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("table") Table table){
        columns.add(table.getColumn1());
        columns.add(table.getColumn2());
        TransactionsSQL.transactions(connection, crudStatementSQL.createTable(table.getName(),columns));
        return new ModelAndView("redirect:/showAll");
    }

    @RequestMapping(value="/showAll")
    public ModelAndView show(){
        return new ModelAndView("showAll","list",metaData.getTableNamesFromDB(connection));
    }

//    @RequestMapping(value = "/show", method = RequestMethod.POST)
//    public ModelAndView showTable(@RequestParam String name){
//        table.put(metaData.getColumnNamesFromDB(connection,name), )
//        return new ModelAndView("show","list",metaData.getColumnNamesFromDB(connection,name),);
//    }
}
