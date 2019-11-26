main = do
    putStrLn "konnichiha, waruldo\nWie heisst du?\n> "
    name <- getLine
    putStrLn ("Hoi " ++ name ++ ", shiawase ni narimasuyouni")
