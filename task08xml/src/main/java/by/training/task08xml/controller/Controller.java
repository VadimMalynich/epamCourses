package by.training.task08xml.controller;

import by.training.task08xml.controller.command.ConsoleCommand;
import by.training.task08xml.controller.command.CommandProvider;
import by.training.task08xml.controller.command.WebCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CommandProvider provider = new CommandProvider();

    private static final char PARAM_DELIMETER = '-';

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name;
        WebCommand webCommand;

        name = request.getParameter("command");
        webCommand = provider.takeWebCommand(name);

        webCommand.execute(request, response);
    }

    public void executeTask(String request) {
        ConsoleCommand executionConsoleCommand;

        executionConsoleCommand = provider.takeConsoleCommand(request);

        executionConsoleCommand.execute(request);
    }
}
