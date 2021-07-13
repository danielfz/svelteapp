<div id="main">
    <div id="left-column">
        <p>pic!</p>
    </div>
    <div id="right-column">
        <input placeholder="What's happening?"/>
        <button>Grunt</button>
    </div>
</div>

<style>
    #main {
        display: grid;
        grid-template-columns: 10% auto;
        grid-template-rows: auto auto;
        background: aquamarine;
    }

    #left-column {
        grid-row: 1 / 3;
        justify-self: center;
        align-self: center;
    }
</style>