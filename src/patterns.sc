theme: /

patterns:

    $blockVN = ($blockV/$blockN)
    $controlVN = ($controlV/$controlN)
    $changeVN = ($changeV/$changeN)
    $enterVN = ($enterV/$enterN)
    $helpVN = ($helpV/$helpN)

    $blockV = ($regexp_i<(за)?блокиров(али?|ана?)>)
    $controlV = (управлять)
    $changeV = ($regexp_i<(из|за|по|с)?ме[нр](ился|ялся|яла?|[ияч]е?тт?ь?)>)
    $create = ($regexp_i<с[ао][сз]да(ть?|ла?)>)
    $comein = (попасть/зайти/войти)
    $enterV = ($regexp_i<в?в[еи](сти|ла?)>/$regexp_i<вход(и[шт]ь?)]>/$regexp_i<в?водить?>)
    $give = $regexp_i<(вы)?дава(ть?т?|вал[иа]?)>
    $forgot = ($regexp_i<заб[ыи]ла?>/Забыл/Забыла/забыл/забыла)
    $get = $regexp_i<получ[иа]ть?>
    $helpV = $regexp_i<помо(гите?|чь?)>
    $know = $regexp_i<у?зна(тт?ь?|етт?е?)>
    $notwork = $regexp_i<н[ие] работ(ает|атт?ь?)>
    $make = ($regexp_i<с?з?д[еи]ла(ть?|ла?|ю|ем)>)
    $pickup = ($regexp_i<(за|подо)бра(ть?|ла?)>)
    $reset = ($regexp_i<с?брос(итт?ь?|ыватт?ь?)?>/сбросить)
    $restore = $regexp_i<в[ао]см?с?тановить?>
    $remember = $regexp_i<(вс)?пом[но][юи]?(те|ть|шь)?>
    $set = ($regexp_i<уст[ао]н[оа]ви(ть?|ла?)>/$regexp_i<з[ао]дать?>/$regexp_i<п[оа]ставить>)
    $see = ($regexp_i<(по)?смотреть?>/$regexp_i<у?видеть>/$regexp_i<у?вижу>)
    $tune = (настроить)

    $application = ($regexp_i<пр[ие]л[ао]жени[еяаию]?>/$regexp_i<(банке?)?[- ]?онлайн[- ]?(банке?)?>/$regexp_i<моб(ильн[оы][мег]о?) приложени[иея]>/$regexp<моб(ильн[оы][мег]о?) банк[ае]?>/$regexp_i<интернет[- ]банк[еа]?>/$regexp_i<личн(ый|ого) кабинета?>)
    $bankomat = ($regexp_i<банкомат(е|ов|ы|а)?>/банкомат)
    $blockN = $regexp_i<блок(ировк[аи])?>
    $card = $regexp_i<к[ап]рт[аоеыу]?(х|чк[аи]?)?й?>
    $error = (ошибка/ошибки/ошибок/ошибк)
    $entrance = $regexp_i<вход[ае]?>
    $enterN = ($regexp_i<в?вода?>)
    $helpN = (помощ/помощь/помощъ)
    $password = ($regexp_i<п[ао]р[ао]лл?ь?>*)
    $pincode = ($regexp_i<пинк?а?[- ]?(код[еау]?)?>/код [для] входа/код [для] $regexp_i<дост[уа]п[ап]?(ми)?>/$regexp_i<pin-?(cod)?e?>/code/cod/$regexp_i<репина?>/код для входа/код входа/можнопосмотретьпинкод/карта/PIN)
    $profil = (профил/профиль)
    $phone = (телефон/мобильный/мобильник)
    $changeN = ($regexp_i<c?и?з?а?(по)?мена?(ени[ея])?>/Смена)
    $controlN = $regexp_i<управлени[ея]>
    $recovery = $regexp_i<в[ао]сc?тановлени[еюя]>
    $setting = (~настройка/~установка/установление/~параметры)
    $login = (логин/логмн/login)

    $first = (1/$regexp_i<п[еи]рв[ыо][йе]>/один/адин)
    $second = (2/$regexp_i<вт[ао]ро[йе]>/два)

    $which = ($regexp_i<как[оа][яй]>)

    $uncorrectly = $regexp_i<н[еи] корр?ек?т?н[аоы]й?>
    $plastik = $regexp<пластик(овой|овая)>
    $valid = (валидный)
    
    $from = (из/с/от)
    $in = (в/во/через/по)
    $on = (на)
    $how = (как/Как)
