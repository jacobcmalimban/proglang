import Data.List
import System.IO

{-
	No /**/ ;(


sumNums = sum [0..999]
maxInt = maxBound :: Int

main = do
    putStrLn "Hello"    

    putStrLn "" ++ sumNums
-}


-- Int
maxInt = maxBound :: Int
minInt = minBound :: Int

-- immutable Var
alway5 :: Int
alway5 = 5

-- math
sumNum = sum[1.999]
prefMod = mod 6 4
infxMod = 6 `mod` 4 -- ~ button
negNum = 6 + (-4) -- note (paren) enclosure
sqrt5 = sqrt(fromIntegral alway5)
tau = 2 * pi
fiveSqr = 5 ** 2

{-
	sin, truncate, round, ceiling, floor
-}


-- Boolean
tnf = True && False
tof = True || False
noT = not(True)

-- lists
priNums = [2, 3, 5, 7]
morPri = priNums ++ [11, 13, 17, 19] 
jokePri = 1 : morPri

twDLst = [priNums, [11,13,17,19]]
lenPri = length priNums
len2D = length twDLst

revPri = reverse morPri
lstEmpty = null revPri

prim3 = morPri !! 2 -- 3rd element
firstPri = head morPri -- 1st element
lastPri = last morPri -- last element
nvrtLast = init morPri -- everything but last

tak3Pri = take 3 morPri -- first 3 elements
rem3 = drop 3 morPri -- after element 3

fourInLst = elem 4 morPri
booPain = fourInLst || False

mxPri = maximum morPri
mnPri = minimum morPri
sumPri = sum morPri
prodPri = product morPri


-- list comp
stpLst = [2,5..21] -- step 3, 21 max (note ends @ 20)
chrLst = ['A', 'D'..'z']

infLst = [5,10..] -- but only creates what's needed


-- l00p
ten3s = take 10 (repeat 3) -- gen 10 3s
replic8 = 10 `replicate` 8 -- gen 10 8s
cyKel = take 20 (cycle stpLst)

-- list arithmetic

st3p4x = [x * 4 -- take every xlement and * 4
    | x <- [1,4..25] -- where x is from 1,4,7
    , x * 2 < 40] -- but only where 2x < 40 (not 22, 26)

fctr13n17 = [x 
    | x <- [1..1000] -- x from 1, 2, .., 1000
    ,  mod x 13 == 0 -- but x divisible by 13
    , x `mod` 17 == 0 -- and x divisible by 17
    ]

xByY = [[x*y
    | y <- [1..10]
        ]
    | x <- [1..10]
    ]


-- list func
srtst = sort [53,26,4,25,14,48,14,48,69]
sumLst = zipWith (+) srtst ( reverse ( 2:srtst )) -- add sorted List to reverse
--			2 truncated from end because zipWith only elements that exist in other list, index must exist in both

-- filters
priGr5 = filter (>5) morPri
eveneg50 = takeWhile (>= -50) [-2,-4..]

-- apply l(eft)/r to other 
addadLst = foldl (+) 2 morPri -- ( ) op happens to all of the elements


-- tuple
twoPl1 = (2, "Pl1")
jDoe = ("John Doe", 42, 'M')
doesName = fst3 jDoe
doesAge = snd3 jDoe


daNaem = ["Alice", "Bob", "Charlie"]
naughtMemAddr = ["1123 West", "4565 East", "7890 Central"]
daAddr = zip daNaem naughtMemAddr


{- Functions
    Definition
        funcName :: (params) -> output
    Pattern Matching
        funcName (param1, p2, pn) = operations (returned Value)
-}
fst3 :: (a, b, c) -> a
fst3 (x, _, _) = x

snd3 :: (a, b, c) -> b
snd3 (_, x, _) = x

addn :: Int -> Int -> Int
addn a b = a + b

main = do
    putStrLn "Who are you?"
    youwu <- getLine
    putStrLn ("Hello " ++ youwu)
