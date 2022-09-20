package com.douzone.bankservlet.controller;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/inputPage")
public class InputController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("inputFrom.jsp");
    }

}
//
// ```
//         은행 프로그램 만들기
//
//         - 은행
//         - 은행 고객
//         - 예금 계좌
//         - 돈
//         - 이율
//         - 예금주
//
//         계좌는 총 5개를 만들고, 이율과 돈은 다 마음대로.
//         - 그 중에서 한 계좌는 -로 만들기 시도(음수 돈은 없으므로 예외)
//         - 그 중에서 한 계좌는 엔화로 만들기 시도(엔화는 지원안하는 통화이므로 예외)
//         - 정상적으로 만들어지는 계좌는 3개
//
//         이자지급
//         - 은행의 모든 계좌를 순회하면서 계좌의 이율 만큼 이자를 지급한다.
//         - 이자 지급을 돌리면 모든 계좌(정상적 계좌는 3개)를 순회하면서, 이자를 지급한다.
//         ```