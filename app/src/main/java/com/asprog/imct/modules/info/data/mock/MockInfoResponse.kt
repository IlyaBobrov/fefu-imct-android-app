package com.asprog.imct.modules.info.data.mock

import com.asprog.imct.modules.info.data.responses.*


val MockTextDep: String =
    "Институт математики и компьютерных технологий (ИМКТ) создан 21 января 2021 года на базе кластера физико-математических кафедр Школы естественных наук и Школы цифровой экономики. ИМКТ создано для формирования научно-образовательного центра мирового уровня, выполняющего научные исследования и подготовку студентов в области математики, математического и компьютерного моделирования, искусственного интеллекта, программной инженерии, прикладных компьютерных технологий и информационной безопасности."

val MockInfoDep = DepartmentResponse(
    textInfo = MockTextDep
)

val MockInfoResponse = InfoResponse(
    department = MockInfoDep,
    directions = listOf(
        DirectionsResponse(
            "01.00.00 Математика и механика",
            listOf(
                DirectionSec(
                    "01.03.02 Прикладная математика и информатика",
                    "Направление дает возможность получить навыки в промышленном программировании. Помимо этого курс учит работать с наукоемкими технологиями, такими как: машинное обучение, Big Data, облачные вычисления, низкоуровневое программирование, разработка математических моделей и алгоритмов, в том числе при создании компьютерных игр. Но и это еще не все математики здесь много и изучается математическое моделирование, численные методы, теория вероятностей"
                ),
                DirectionSec(
                    "01.03.04 Прикладная математика",
                    "Направление нацелено на подготовку аналитиков в области разработки и применения математических методов и моделей объектов. Также обучают проектированию, оптимизации,  внедрению и контролю управленческих процессов, планированию и организации деятельности."
                )
            )
        ),
        DirectionsResponse(
            "02.00.00 Компьютерные и информационные науки",
            listOf(
                DirectionSec(
                    "02.03.01 Математика и компьютерные науки",
                    "Направление позволяет узнать все о технологиях виртуальной и дополненной реальности, облачных технологиях, компонентах робототехники, искусственном интеллекте и машинном обучении. Программа рассчитана не только на усвоение знаний, но и на развитие навыков написания научно-исследовательской работы и на разработку проектов."
                ),
                DirectionSec(
                    "02.03.03 Математическое обеспечение и администрирование информационных систем",
                    "Направление дает возможность понять весь цикл разработки программных систем от поставленной заказчиком задачи до тестирования реализованного решения. В разработке программ ценится не индивидуальная работа, а коллективная. Это направление обучает студентов технологией коллективной разработки."
                )
            )
        ),
        DirectionsResponse(
            "09.00.00 Информатика и вычислительная техника",
            listOf(
                DirectionSec(
                    "09.03.02 Информационные системы и технологии",
                    "Направление обучает защите данных, противостоянию компьютерным атакам, расследованию компьютерных инцидентов и прочее."
                ),
                DirectionSec(
                    "09.03.03 Прикладная информатика",
                    "Направление, где обучают разработывать, внедрять и сопровождать информационные системы для оптимизации процессов. Здесь разрабатывают архитектуру информационных систем, проектируют техническую реализацию систем для разнообразных компьютерных, операционных и сетевых платформ, выполняют программирование компонентов систем, отладку, тестирование и эксплуатацию, используют при этом компьютерные средства автоматизации разработок"
                ),
                DirectionSec(
                    "09.03.04 Программная инженерия",
                    "Направление нацелено на оптимизацию процессов разработки программ. На данный момент в программировании задействовано большое количество программ с большим количеством данных и необходимо уметь пользоваться шаблонами, производить рефакторинг кода и качественно оценить ее работоспособность."
                )
            )
        ),
        DirectionsResponse(
            "10.00.00 Информационная безопасность",
            listOf(
                DirectionSec(
                    "10.03.01 Информационная безопасность",
                    "Направление рассчитано на изучение выявления угроз безопасности на этапе проектирования информационных систем, освоение безопасной разработки и тестирования безопасности."
                ),
                DirectionSec(
                    "10.05.01 Компьютерная безопасность (специалитет)",
                    "Направление дает возможность узнать как избежать утечек данных пользователей. Предполагается получение знаний, позволяющих определить источники угроз информационной безопасности и построение эффективной системы защиты, а также приобритение умений в шифровании и дешифровании данных."
                )
            )
        )
    ),
    teachers = listOf(
        TeachersResponse(
            "Сущенко Андрей Андреевич",
            "https://sun9-71.userapi.com/impg/IbsP13mJ6qcUsnt9ER_0dmpFTRCLGKBJCGeNag/JUStfxXhkpI.jpg?size=96x96&quality=96&sign=6214af53f01d1eb240da55f9b200ae54&type=album"),
        TeachersResponse(
            "Абакумов Александр Иванович ",
            "https://sun9-71.userapi.com/impg/pWW6ipQLoDEIYlkb8qvxkeFtLgH5oMleaRMXiQ/Oe7Wg_UeL-Y.jpg?size=195x195&quality=96&sign=3546c266f800f90a890f9678caf2b998&type=album"),
        TeachersResponse(
            "Акулов Алексей Сергеевич",
            "https://sun9-74.userapi.com/impg/MVjxHP1emiSGd94i6pe-BKs8pj1OrX3ZosF6qQ/kpFqAdkSIJM.jpg?size=195x195&quality=96&sign=4e3ca1ecffca9d6a4f9368999567df0f&type=album"),
        TeachersResponse(
            "Алексанин Анатолий Иванович",
            "https://sun9-26.userapi.com/impg/sUOhbQx0X9kpcb0OBL5OIGkf20P706gZnlkhkg/GDDtQHRVz0Y.jpg?size=195x195&quality=96&sign=baaeed405eba02966fc31b7709b0d996&type=album"),
        TeachersResponse(
            "Алексанина Марина Георгиевна",
            "https://sun9-51.userapi.com/impg/vBYt6QiOfNXlbiJkDhXNGHVcNW3yjx2UjBEf4g/yLpPCPyxLiE.jpg?size=96x96&quality=96&sign=bad9d7a695979fd7146214ff756794c6&type=album"),
        TeachersResponse(
            "Алексеев Геннадий Валентинович ",
            "https://sun9-51.userapi.com/impg/orVXZ9SZYnEbWFwyvICHtO-kX10xSmQVHVtA2w/nxJZQcqYCtU.jpg?size=96x96&quality=96&sign=50af2579125597859b1cd6cd9305005e&type=album"),
        TeachersResponse(
            "Баян Евгений Вячеславович",
            "https://sun9-45.userapi.com/impg/3Q387ZDdT278mh_-acE6yAyAYsI_vL1eQjYlmg/BlfWE54_yPY.jpg?size=96x96&quality=96&sign=9569aa688f98bc644a17063f4240fef7&type=album"),
        TeachersResponse(
            "Безотосная Анна Дмитриевна",
            "https://sun9-28.userapi.com/impg/qzl1HpHqEcMcZjQd6UXrE8cgWhs9TC47-yLAHQ/ao9juLGOgCg.jpg?size=96x96&quality=96&sign=b3c60fa21d64c3e649d93d475377bef9&type=album"),
        TeachersResponse(
            "Беспалов Валерий Михайлович",
            "https://sun9-15.userapi.com/impg/dNs663UDcf8pNym_8orFhIUn2gh0aJpoPDNEVg/4hZq3hPXd4A.jpg?size=195x195&quality=96&sign=62f905e407150e1a56a8a2732072d0a3&type=album"),
        TeachersResponse(
            "Боровик Алексей Игоревич",
            "https://sun9-74.userapi.com/impg/vzC7grJ-VC_7fPxF-WDjGjYmFP1sclpnP0F1Cg/6aYgmSDFL-I.jpg?size=195x195&quality=96&sign=4d1957017ce95ecaed9bb23b75f370ae&type=album"),
        TeachersResponse(
            "Бризицкий Роман Викторович",
            "https://sun9-63.userapi.com/impg/uq1WEJo3w5ceN8NgQu4Hd7qfkX3uHyY9KC-GyQ/Nv-ua0G5HWQ.jpg?size=195x195&quality=96&sign=8164afa378029f27e613940b045d89b6&type=album"),
        TeachersResponse(
            "Бузалов Павел Константинович",
            "https://sun9-77.userapi.com/impg/AekstzlRlsPGXJgh6V51OoeEyL7xkcHMFXn6Ag/-Mxrfbusc3I.jpg?size=195x195&quality=96&sign=fc341c82be94c12c27302f060cb27418&type=album"),
        TeachersResponse(
            "Волкогонова Юлия Викторовна",
            "https://sun9-79.userapi.com/impg/P36HFmJM9XPX_VO_zAvf7janwDVz84V6ZlCG8A/yIyxBVKhCd8.jpg?size=195x195&quality=96&sign=cb214a13fa953fbd763cfaa750df55a8&type=album"),
        TeachersResponse(
            "Глущенко Даниил Александрович",
            "https://sun9-7.userapi.com/impg/ndgX3ZUmqN8_3ZicVRZp-_dVEJqDPF36qsi0Dg/LbU2M8bKL5Y.jpg?size=195x195&quality=96&sign=6b35a0cd78c2b01d68351887233f785b&type=album"),
        TeachersResponse(
            "Гузев Михаил Александрович ",
            "https://sun9-23.userapi.com/impg/vm4xzgw-ktNZ4034L-2uPd3HU6bDQ6TgGezpuA/R60eZOWifZs.jpg?size=195x195&quality=96&sign=177f8608db6bc96660aa4c1003cf6ed0&type=album"),
        TeachersResponse(
            "Журавлев Павел Викторович",
            "https://sun9-36.userapi.com/impg/hMGPHXO2XnR3XV8xNS6RGH9FWOyPix5SvSQX1Q/SF2gVjocVXk.jpg?size=195x195&quality=96&sign=0e8a1c28001ca34f6597124810df2ec4&type=album"),
        TeachersResponse(
            "Изотова Ирина Викторовна",
            "https://sun9-30.userapi.com/impg/hcx7YxjJRYY2YOpgUcNU7YF0kcBU9rtxpnoZ_Q/i673M73ShY4.jpg?size=195x195&quality=96&sign=981533e34d652b91be3398fbc52bc3b0&type=album"),
        TeachersResponse(
            "Кан Владимир Алексеевич",
            "https://sun9-77.userapi.com/impg/0vh_e9_2stEvGhKFkF_0OlrV_ipzcnbHfcob3w/0_3AEvFTKf8.jpg?size=195x195&quality=96&sign=bebbf0da6530b92f4ef49545573d4334&type=album"),
        TeachersResponse(
            "Кленина Надежда Викторовна",
            "https://sun9-15.userapi.com/impg/mlaakjBj_yDVuysM2JBb4MoA_fjPZN1jGpZVyg/CdLibocBkj8.jpg?size=195x195&quality=96&sign=b4889eef9d380725742b94c18b5b2e48&type=album"),
        TeachersResponse(
            "Коваленко Евгений Олегович",
            "https://sun9-47.userapi.com/impg/pNoVoCVIyaJeEoTchvzMjZK9hWxcjiQP9YdRYA/PGRQwp7bn-k.jpg?size=195x195&quality=96&sign=057796e8e2b0ff8fefb1c41402934a18&type=album"),
        TeachersResponse(
            "Ковтанюк Андрей Егорович",
            "https://sun9-49.userapi.com/impg/jaY-oPlv5lNII-QItqjDLmNexWRrKOf7OfxW9w/5E2GksGNSJU.jpg?size=96x96&quality=96&sign=651dfae63f161dfd3bae890d8fef6ed7&type=album"),
        TeachersResponse(
            "Колобов Александр Георгиевич",
            "https://sun9-76.userapi.com/impg/DYbWuuUILgn4uRW4WkHLY0qPVMAeJApFWk8Z9w/vOOMbToGQOw.jpg?size=96x96&quality=96&sign=9318ea68d77709f137f097e77dc02980&type=album"),
        TeachersResponse(
            "Краснопеев Сергей Михайлович",
            "https://sun9-44.userapi.com/impg/Xm9QA-RlWXGxSUrpNkku-UqB8lzJeSp1y9XtKg/HxF-hY6fgGQ.jpg?size=195x195&quality=96&sign=ccb836d825052e2fe17be48a7853c436&type=album"),
        TeachersResponse(
            "Кузин Антон Алексеевич",
            "https://sun9-75.userapi.com/impg/O9jbpYY43bBY5fh9kAlXXwYoLlqPxgdV0MWw0g/UAMabvCKha4.jpg?size=96x96&quality=96&sign=c5066822299412b47fbfb04a09099190&type=album"),
        TeachersResponse(
            "Кузнецова Наталья Владиславовна ",
            "https://sun9-76.userapi.com/impg/n1gZURmmTBxx_Hvh7wIi1cerN3CYSP2dcXcnpA/aX1aBKEGLqE.jpg?size=195x195&quality=96&sign=1bf44b6f7f6553d1b599cc2b34b8bba0&type=album"),
        TeachersResponse(
            "Курочкина Ирина Алексеевна",
            "https://sun9-34.userapi.com/impg/JRtzm80LmQWT6lr8x8p3f6XZD9NN88PG_kbCsw/m2sM5HPxa4s.jpg?size=195x195&quality=96&sign=c36ae9e6e6e1308d29ee72569b998d7b&type=album"),
        TeachersResponse(
            "Малыкина Ирина Анатольевна",
            "https://sun9-68.userapi.com/impg/zFlI0o0M5DrdqzK9oS1kKY3DvOqb6aP3b8V0QA/_C-k1Mw0mTE.jpg?size=96x96&quality=96&sign=785b7ebd92fc2f6d5c34488078d2f63c&type=album"),
        TeachersResponse(
            "Марущенко Евгений Андреевич",
            "https://sun9-74.userapi.com/impg/ku0ePnL5aa2FIVekfD1u8qH6xeloA_tIPw33Mg/eBjL1Cpl2qA.jpg?size=195x195&quality=96&sign=84e568eac3b77754732f25e84e62dc30&type=album"),
        TeachersResponse(
            "Матусовская Светлана Владимировна",
            "https://sun9-53.userapi.com/impg/0yFzyxPsHhMXvgImACAhqyo_rpvdE5LWooET2Q/Krz9KmkcLy8.jpg?size=195x195&quality=96&sign=0501e84602afcc98b1f9cbec013c6812&type=album"),
        TeachersResponse(
            "Месенев Павел Ростиславович",
            "https://sun9-84.userapi.com/impg/7J7RY4eGytSgELs8nxPo51v0-Pdem6ya0EEYAw/BdR73fCv7sg.jpg?size=96x96&quality=96&sign=c27a79c2f3df9395689f5293706a7bb9&type=album"),
        TeachersResponse(
            "Мищенко Анна Михайловна",
            "https://sun9-83.userapi.com/impg/pfS-MFwQH9f7cLc-8XIc8yqKIlOSIZ2PcCA5kQ/82xBFyfGsXU.jpg?size=195x195&quality=96&sign=6de92ea92971618a973917f9a949df7d&type=album"),
        TeachersResponse(
            "Мокрицкая Елена Борисовна",
            "https://sun9-77.userapi.com/impg/UTsT8oNBQIgv2VqP8bvPmtRVOUX5bK9I6hIKIg/ZzOxXR_jkCE.jpg?size=96x96&quality=96&sign=d546838028627354329f4b6d3da3034c&type=album"),
        TeachersResponse(
            "Никитина Евгения Юрьевна",
            "https://sun9-67.userapi.com/impg/KFDY4EIp82QKnUv8JZPG67NCU2KkwICk0sZBKg/N8zCOdT49yw.jpg?size=195x195&quality=96&sign=4ab6d081fb6fdfdc345d8c5008ff6299&type=album"),
        TeachersResponse(
            "Павленко Дмитрий Русланович",
            "https://sun9-86.userapi.com/impg/EREszfR7e8iA4OnZ1p_-xNO6wZPpQvjotJSpEQ/Ym1CZ6iM7xo.jpg?size=96x96&quality=96&sign=0669f4f558883abfcf2294b21180c19e&type=album"),
        TeachersResponse(
            "Пак Николай Михайлович",
            "https://sun9-73.userapi.com/impg/hz3WeRAZvUNpBWSUcVEJXO57jxQRSMqPIRKqqw/NNRA9LH9CrM.jpg?size=96x96&quality=96&sign=9f869fa4f2de1b2026359e43988a5cbd&type=album"),
        TeachersResponse(
            "Пак Светлана Яковлевна",
            "https://sun9-14.userapi.com/impg/tQV8yUC4I_9lLl_TD9cQV96k9tq4efZ9AuvTwA/Q5JkfDokZy0.jpg?size=195x195&quality=96&sign=a4b96be512e8a0dbb0eb3fabeb41fbaa&type=album"),
        TeachersResponse(
            "Пак Сергей Борисович",
            "https://sun9-40.userapi.com/impg/h6ywwNXhEbf66LI2ak9QRg4hpo4_ZPTXN4hbrg/FIBQZHyLO-8.jpg?size=195x195&quality=96&sign=559bee4656b65f6c6fbaab11ed2e376c&type=album"),
        TeachersResponse(
            "Пак Татьяна Владимировна",
            "https://sun9-59.userapi.com/impg/cMNf72mkT2uPFJziRnMMx_HSXHxd5JX3CPF9SQ/3N80F5wo91I.jpg?size=96x96&quality=96&sign=784c6f11d3fd631c0b0e4255639a10e0&type=album"),
        TeachersResponse(
            "Пермяков Михаил Степанович",
            "https://sun9-4.userapi.com/impg/N7ivLSwkj-JKtuYj01fwWwV2ygIEVlcrzfLLZg/_OedkZ5aslk.jpg?size=195x195&quality=96&sign=02a042a1046a45fc1ced6ebb81fcbf0e&type=album"),
        TeachersResponse(
            "Петров Павел Сергеевич",
            "https://sun9-80.userapi.com/impg/lNxsmu3rh5KWGoP63o6kAmsqqjquhwrA9LPCFA/V0oYsL8q87g.jpg?size=195x195&quality=96&sign=c9ccf2f13e4256a558e88663efc90065&type=album"),
        TeachersResponse(
            "Прохоров Игорь Васильевич",
            "https://sun9-77.userapi.com/impg/fNGU6K3T_QcZUWHZW36Z8Klu61eRpQxfAYH16A/KdNeqxbPDgc.jpg?size=195x195&quality=96&sign=eccabfef677cdecdee8ecd9d742fe3ee&type=album"),
        TeachersResponse(
            "Святуха Иван Владимирович",
            "https://sun9-68.userapi.com/impg/FuWhC7UaAhZ1_6aaOuKIB1_YCnYfUilCcRBInw/NkvupHk18NA.jpg?size=195x195&quality=96&sign=9bcd8caba9a371b2832bb507eb01f9c3&type=album"),
        TeachersResponse(
            "Селезнев Тим Эдуардович",
            "https://sun9-70.userapi.com/impg/8Rhf98n2idpk53H4jfo_6GDOPm4lf-T2wB7Iow/Gz_8JIsdOQ0.jpg?size=195x195&quality=96&sign=d5ecf94d386e39f2dc7ba38fe3167059&type=album"),
        TeachersResponse(
            "Селезнева Екатерина Викторовна",
            "https://sun9-23.userapi.com/impg/Ffa85KmGbdtS2b48eR2Zb0OPwwyXUJzlDjyDiw/j1knZu8MoLY.jpg?size=195x195&quality=96&sign=0c63cbbb243f57b48d824d838018047a&type=album"),
        TeachersResponse(
            "Серга Инна Викторовна",
            "https://sun9-30.userapi.com/impg/hcx7YxjJRYY2YOpgUcNU7YF0kcBU9rtxpnoZ_Q/i673M73ShY4.jpg?size=195x195&quality=96&sign=981533e34d652b91be3398fbc52bc3b0&type=album"),
        TeachersResponse(
            "Степнов Андрей Александрович",
            "https://sun9-38.userapi.com/impg/OtumnN9RfVLWQdt8RyH1xoqvtXwaGaxgTnDkng/j95EQHaMAUc.jpg?size=195x195&quality=96&sign=8f973f5b9dabac0ee3d9e281690a665f&type=album"),
        TeachersResponse(
            "Тарасова Ирина Михайловна",
            "https://sun9-79.userapi.com/impg/HpMXUy2lC3vgCH4EMgL92OKp4kbti9n1-SepqA/qvqUWZOEYv0.jpg?size=195x195&quality=96&sign=fe2ccc8da0b90679f955398512e0c645&type=album"),
        TeachersResponse(
            "Фищенко Виталий Константинович",
            "https://sun9-85.userapi.com/impg/K1X9w5wqGBsKY8YgBN5WnDXwYNqrIr3iu0AxRQ/x2x677ohI_E.jpg?size=195x195&quality=96&sign=98e126d62a2d37924069527282836d67&type=album"),
        TeachersResponse(
            "Цечоев Богдан Муссаевич",
            "https://sun9-20.userapi.com/impg/v1GrQtmBtV7WdRWTDQur15J92yodAVGV9EuMag/sjf2oUQDkU8.jpg?size=195x195&quality=96&sign=f2d7f8c80732fa92bdc82a1c8b9bb584&type=album"),
        TeachersResponse(
            "Цициашвили Гурами Шалвович",
            "https://sun9-30.userapi.com/impg/9lzFvhr8JPcpHJA8gsjZD71hCoHvxTgsm74wlA/yZK-_nEK4g0.jpg?size=195x195&quality=96&sign=f3458330b1f10f668258d7ff5bcb8a19&type=album"),
        TeachersResponse(
            "Цой Алексей Александрович",
            "https://sun9-39.userapi.com/impg/D6LEm4BRFehlgFd4s95vRpP8o7QR2nBtv57xOQ/Jfuz-n8Rbgw.jpg?size=195x195&quality=96&sign=5589d2fc3290201f7abd91ff9106c044&type=album"),
        TeachersResponse(
            "Чараева Евгения Вахитовна",
            "https://sun9-30.userapi.com/impg/5nfz-a6esMh3ZeRHBn0nI1brtyp24eDb--y3aw/XwGmk0gH63E.jpg?size=96x96&quality=96&sign=8348f39eb5c32303186db9b301e14b68&type=album"),
        TeachersResponse(
            "Чеботарев Александр Юрьевич ",
            "https://sun9-85.userapi.com/impg/8342jEBQr8-V4cDYR6X-1YheReFhApmuMfRamQ/IGN2uEbWlO4.jpg?size=96x96&quality=96&sign=907bff4583ebd205cdaaf19f46e9dae6&type=album"),
        TeachersResponse(
            "Черныш Елена Валерьевна",
            "https://sun9-75.userapi.com/impg/BCdKV_iAtLyGH1zvr0ogJgxLpw8Emf-SEzLjCQ/bZSb1kVVmo4.jpg?size=195x195&quality=96&sign=1c074db67007761545af585cd2a99342&type=album"),
        TeachersResponse(
            "Чернышева Галина Юрьевна",
            "https://sun9-58.userapi.com/impg/lEtiVrmc0cPAf8lBrB3_VupZMN2i8HcwCQS0VA/ErCTUE1laa0.jpg?size=195x195&quality=96&sign=2382ae25203f971b9baff40d8e44f7ba&type=album"),
        TeachersResponse(
            "Шевченко Игорь Иванович",
            "https://sun9-34.userapi.com/impg/FecLEpUAlkjTZQElHjP9AX-4i5wmcy4jmrQmsQ/QlJ3SkqD0jE.jpg?size=195x195&quality=96&sign=e9db62c1739d93d3c353bcfb7874f45e&type=album"),
        TeachersResponse(
            "Шулькин Евгений Владимирович",
            "https://sun9-71.userapi.com/impg/pWW6ipQLoDEIYlkb8qvxkeFtLgH5oMleaRMXiQ/Oe7Wg_UeL-Y.jpg?size=195x195&quality=96&sign=3546c266f800f90a890f9678caf2b998&type=album"),
        TeachersResponse(
            "Яровенко Иван Петрович",
            "https://sun9-54.userapi.com/impg/fpE31tiihCveW4s0GQBkHlIq3s6vTWVAwOoN0w/B5SEkoTCqz0.jpg?size=195x195&quality=96&sign=6ea81c91204dc612977a1f244f2681b3&type=album"),
        TeachersResponse(
            "Ярощук Игорь Олегович",
            "https://sun9-85.userapi.com/impg/f5n1_jtvEwNN2_RLZA9jboPlXo1QfCynukt-Ag/GLEPyiLVt9s.jpg?size=195x195&quality=96&sign=71a39061f3907c019b2951ed98c6417d&type=album"),
        TeachersResponse(
            "Жандармова Ирина Владимировна",
            "https://sun9-49.userapi.com/impg/3GeYHA_6nJ5mP43XF-gIjkiYUMejhsCHack6rQ/9KNndEO42QE.jpg?size=96x96&quality=96&sign=6ba1f8dddfaa7f6ae5bce4d21850f319&type=album")
    )
)


