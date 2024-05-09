# Flow Graph
1. Node 1 (conectarBD()) is connected to Node 2 (try block) and Node 6 (verificarUsuario() method call).
2. Node 2 (try block) is connected to Node 4 (return conn) and Node 3 (catch block).
3. Node 3 (catch block) is connected back to Node 4 (return conn).
4. Node 6 (verificarUsuario() method call) is connected to Node 5 (String sql = "").
5. Node 5 (String sql = "") is connected to Node 7 (Prepare SQL statement).
6. Node 7 (Prepare SQL statement) is connected to Node 8 (Set parameters).
7. Node 8 (Set parameters) is connected to Node 9 (Execute query).
8. Node 9 (Execute query) is connected to Node 10 (if condition).
9. Node 10 (if condition) is connected to Node 4 (return conn) and Node 11 (return result).
![](/img/White%20Box%20Flow%20Graph.png)