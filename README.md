# MarketAPI

This was a project for a job interview in which I had to do my first API in Spring boot

<h1>Kávézó Teszt Projekt</h1>
<div>Fontos: Készits magadnak egy saját branchet a master ből és abba dolgozz (ne felejtsd el majd fel pusholni remote ba)</div>
<br>
<br>
<ol>
    <li>
        <div>
            <div>
                Keszits magadnak egy sajat branch et a master bol, e
                A feladat egy olyan endpoint készítése, amely fogad egy összetevő listát.
                A lista alapján összeállít egy rendelést, visszaadja a rendelésben szereplő összetevőket és a végösszeget.
            </div>
            <div>
                <p>Példa:</p>
                <p>Request: [ { "name": "milk", "quantity": 1 }, { "name": "coffee", "quantity": 1 } ]</p>
                <p>Response: {"description": "milk coffee", "cost": 1.5}</p>
            </div>
            <div>
                <p>Elvárások:</p>
                <ul>
                    <li>A rendeléseket mentse le egy adatbázisba.</li>
                    <li>Ha egy olyan összetevő van a requestbe ami nem létezik adjon vissza egy ennek megfelelő Http error.</li>
                    <li>Fontos, hogy legyen bővíthető új összetevőkkel.</li>
                </ul>
            </div>
            <div>
                <p>Összetevők:</p>
                <ul>
                    <li>coffee</li>
                    <li>milk</li>
                    <li>caramel</li>
                    <li>chocolate</li>
                    <li>cream</li>
                    <li>ice cream</li>
                    <li>sugar</li>
                    <li>sweetener</li>
                    <li>cinnamon</li>
                </ul>
            </div>
        </div>
    </li>
    <li>
        <div>
            <p>Készits egy endpoint-ot amely visszaadja a rendelésekset.</p>
        </div>
    </li>
    <li>
        <div>
            <p>Készits egy endpoint-ot amely töröl egy rendelést ID alapján.</p>
        </div>
    </li>
    <li>
        <div>
            <p>Készits egy endpoint-ot amely módosít egy rendelést a beérkező új összetevők listája alapján.</p>
        </div>
    </li>
    <li>
        <div>
            <p>Készits egy endpoint-ot amely visszaadja a lehetséges összetevők listáját.</p>
        </div>
    </li>
    <li>
        <div>
            <p>Készits egy endpoint-ot amely egy összetevő alapján visszaadja az összes olyan rendelést ami tartalmazza a megadott összetevőt.</p>
        </div>
    </li>
</ol>
