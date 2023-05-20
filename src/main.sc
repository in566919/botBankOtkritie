require: patterns.sc
theme: /
    
    state: Start
        q: $regex</start>
        a: Что вас интересует?
    
    state: ChangePinPas
        q!: * {($changeVN/$controlVN/$enterVN/$forgot/$make/$create/$set/$setting/$which/$know/$remember/$tune/$restore/$see/$pickup/$recovery/$entrance/$reset/$helpVN/$uncorrectly/$error/$give) * ($pincode/$password)} *
        # Перезайти в приложение не помогло. Также выходит ошибка. Попробую в банкомате, но есть сомнения, что в первую очередь при работе с картой будет запрошен валидный пин код. А у меня его на текущий момент для этой карты нет
        q!: * {$application * $error * ($bankomat * $card)} *
        q!:  * $pincode *
        a:  Здравствуйте!
        a:  Сейчас расскажу порядок действий.
            Выберите, что именно планируете сделать:
            1. Поменять пароль для входа в приложение.
            2. Поменять PIN-код от карты.
            Пожалуйста, отправьте цифру, соответствующую вашему выбору.
        script:
            #log(JSON.stringify($parseTree));
            $reactions.timeout({interval: '10s', targetState: '/WhatAreYouInterested'});
        
        state: ChangePasswordApp
            q: * $first *
            q!: * {($changeVN/$controlVN/$blockVN/$enterVN/$forgot/$make/$create/$set/$setting/$which/$know/$remember/$tune/$restore/$see/pickup/$recovery/$entrance/$reset/$helpVN/$uncorrectly/$error/$login) * ($pincode/$password) * ($application/$phone/$profil)} *
            # как изменить пароль и логин ?
            q!: * {($changeV/$know) * $login * $password} *
            q!: * {($password/$pincode) * $application} *
            a:  Смена пароля от приложения возможна несколькими способами:
                1. на экране "Профиль" выберите "Изменить код входа в приложение".
                2. введите SMS-код.
                3. придумайте новый код для входа в приложение и повторите его.
            script:
                #log(JSON.stringify($parseTree));
                $reactions.timeout({interval: '2s', targetState: './RegisterAgain'});

            state: RegisterAgain
                a:  Либо нажмите на кнопку "Выйти" на странице ввода пароля для входа в приложение.
                    После чего нужно будет заново пройти регистрацию:
                    1. ввести полный номер карты (если оформляли ранее, иначе номер телефона и дату рождения),
                    2. указать код из смс-код,
                    3. придумать новый пароль для входа.
                script:
                    #log(JSON.stringify($parseTree));
                    $reactions.timeout({interval: '2s', targetState: '/Bye'});    

        state: ChangePinCodeCard
            q: * $second *
            q!: * {($changeVN/$controlVN/$blockVN/$enterVN/$forgot/$make/$create/$set/$setting/$which/$know/$remember/$tune/$restore/$see/$pickup/$recovery/$entrance/$reset/$helpVN/$uncorrectly/$error) * ($pincode/$password) * $card} *
            q!: * {($pincode/$password) * $card} *
            # Как в приложении сменить пароль на пластиковой карте
            q!: * {($in $application) (($changeVN) ($password/$pincode)) ($on [$plastik] $card)} *
            # Я хочу менять пинкод карта . Как можно менять онлайн?
            q!: * {$changeV * ($password/$pincode) * ($changeV [$in] $application)} *
            # Забыла пин код от карты. Хочу сменить в приложении. Пишет что смс не отпраляется и изменения недоступны 
            q!: * ($forgot ($pincode/$password) [$from] $card) * ($changeV $in $application) * 
            # Как посмотреть пин-код карты в онлайн банке
            q!: * (($how * $see) * (($pincode/$password) [$from] $card) * ($in $application)) *
            # Никакой. Будто все ок. А в банкомате написано неверный пин или позднее
            q!: * {$bankomat * $pincode} *
            # По-прежнему не работает карта, пин-код через приложение не меняет
            q!: * {($notwork * $card) * ($pincode $in application) * $changeV} *
            # По-прежнему не работает карта, пин-код через приложение не меняет, ближайший банкомат в 200км, как пользоваться картой?
            q!: * {$card * ($notwork * $application) * $changeV} *
            # Как создать пин-код карты через мобильное приложение?
            q!: * {($create * {$pincode $card}) * ($in $application)} *
            # Добрый вечер, я забыла от своей премиум карты пин-код, я могу его просто сменить через приложение? Или запрашивается старый?
            q!: * {$forgot * ($from * $card * $pincode) * $changeV $in $application} *
            a:  Это можно сделать в приложении:
                1. На экране "Мои деньги" в разделе "Карты" нажмите на нужную.
                2. Выберите вкладку "Настройки".
                3. Нажмите "Сменить пин-код".
                4. И введите комбинацию, удобную вам.
                5. Повторите ее.
            a:  И все готово!
                Пин-код установлен, можно пользоваться.😊
            go!: /Bye
        
    state: ICanOnly
        q!: *
        a: Я могу только помочь поменять пин-код от карты или приложения

    state: Bye
        a: Приятно было пообщаться. Всегда готов помочь вам снова😊

    state: WhatAreYouInterested
        a: Уточните, что вас интересует?
        go: /ChangePinCode
        
    
    