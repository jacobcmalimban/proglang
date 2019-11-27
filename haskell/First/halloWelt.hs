msg :: String
msg = "\nNo!"

main :: IO ()
main = do
    putStr "konnichiha, waruldo\nWie heisst du?\n> "
    name <- getLine    
    putStrLn ( "Hoi " ++ name ++ ", shiawase ni narimasuyouni")

    putStrLn msg
