--testFun :: String -- input
--        -> String -- output
--testFun t = sort t

main = do
    putStr "konnichiha, waruldo\nWie heisst du?\n> "
    name <- getLine    
    putStrLn ( "Hoi " ++ name ++ ", shiawase ni narimasuyouni")

--    let print = putStrLn
--    print("Was ist dein Quest?\n> ")
--    fun <- testFun getLine
--    putStrLn $ "I c, you are going to: " ++ fun
