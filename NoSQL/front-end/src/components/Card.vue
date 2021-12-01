<template>
  <div class="card-container">
      <div class="ccard-header">
        <slot name="header"></slot>
      </div>
      <div style="padding: 16px; padding-top: 0px; width: 100%">
        <slot name="body"></slot>
      </div>
      <div class="card-actions">
        <slot name="actions"></slot>
      </div>
  </div>
</template>

<script>
export default {
    name: 'Card'
}
</script>

<style>
.card-container {
  border: 1px solid #eee;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  border-radius: 8px; 
  padding: 0;
  margin: 0;
    box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
}

.ccard-header {
  margin-bottom: 16px;
  width: 100%;
  color: deepskyblue;
  padding: 8px 16px;
  background-color: white;
}

.card-header h2, .card-header h1, .card-header h3, .card-header h4 {
    margin-bottom: 0;
}

.card-actions {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;
  width: 100%;
  padding-bottom: 16px;
  padding-right: 16px;
}

</style>