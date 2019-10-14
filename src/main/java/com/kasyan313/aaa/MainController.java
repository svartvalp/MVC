package com.kasyan313.aaa;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class    MainController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping(value="/dates/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<String> postRequest(@RequestBody List<Date> request)
    {
        List<String> output = new ArrayList<>();
       for(int i = 0;  i < request.size(); i++)
        {
            if(request.get(i).isValue())
            {
               output.add(request.get(i).getDate());
            }
        }
        return output;
    }

    @RequestMapping(value = "/post")
    public String getPOSTView()
    {
        return "dates";
    }

    @RequestMapping(value = "/dates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<String> index(@RequestParam("months") String months)
    {
        String[] mass = months.split(",");
        String[][] potom = new String[mass.length][2];
        for(int i = 0; i < mass.length; i++)
        {
            potom[i] = mass[i].split("-");
        }
        List<String> array = new ArrayList<>();
        for(int i = 0; i < potom.length; i++) {
            int year = Integer.parseInt(potom[i][0]);
            int month = Integer.parseInt(potom[i][1]);
            Calendar begin = new GregorianCalendar(year, month - 1, 1);
            while (begin.get(GregorianCalendar.MONTH) == month - 1) {
                if ((begin.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SATURDAY) || (begin.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY)) {
                    array.add(begin.get(Calendar.YEAR) + "-" + (begin.get(Calendar.MONTH) + 1) + "-" + begin.get(Calendar.DAY_OF_MONTH));
                }
                begin.add(GregorianCalendar.DAY_OF_YEAR, 1);
            }
        }
        return  array;
    }
}
